public class Main {
    public static void main(String[] args)
    {
        // Input: List of doubles
        // Input: Target double
        // Output: Num occurrences of target double
        double[] A = {2.3, 5.4, 3.1, 1.5, 2.3};
        double[] B = {};
        double target = 2.3;

        System.out.println(numOccurrences(A, target,0, A.length-1, 0));
        System.out.println(numOccurrences(B,target,0,B.length-1, 0));

        // Input: List of doubles
        // Output: Minimum in the list

        System.out.println(findMin(A,Double.POSITIVE_INFINITY,0,A.length-1));

        System.out.println(findMin(B,Double.POSITIVE_INFINITY,0,B.length-1));


        // Input: money, cost per chocolate, wrappers needed per free chocolate
        // Output: How many chocolates bobby got
        System.out.println("Total chocolates: " + totalChocolates(4,0,1,2));

    }

    public static int totalChocolates(int dollars, int wrappers, int cost, int wrappersRequired)
    {
        if(dollars>=cost)
        {
            return 1 + totalChocolates(dollars-cost, wrappers + 1, cost, wrappersRequired);
        }
        else if(wrappers>=wrappersRequired)
        {
            return 1 + totalChocolates(dollars,wrappers-wrappersRequired+1,cost,wrappersRequired);
        }
        else
        {
            return 0;
        }
    }
    
    public static double findMin(double[] Arr, double min, int start, int end)
    {
        try
        {
            if (Arr.length == 0)
            {
                throw new ArrayIndexOutOfBoundsException("Empty Array");
            }

            if (start > end)
            {
                return min;
            }

            if (start == end)
            {
                if (Arr[start] < min)
                {
                    return Arr[start];
                }
                else
                {
                    return min;
                }
            }

            int mid = (start + end) / 2;
            double newMin = findMin(Arr, min, start, mid);
            return findMin(Arr, newMin, mid + 1, end);

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Empty Array");
            return -1;
        }
    }

    public static int numOccurrences(double[] Arr, double target, int start, int end, int Accum) {
        try {
            if (Arr.length == 0)
            {
                throw new ArrayIndexOutOfBoundsException("Empty Array");
            }

            if (start > end)
            {
                return Accum;
            }

            if (start == end)
            {
                if (Arr[start] == target)
                {
                    return Accum + 1;
                }
                else
                {
                    return Accum;
                }
            }

            int mid = (start + end) / 2;

            if (Arr[mid] == target)
            {
                Accum += 1;
            }

            Accum = numOccurrences(Arr, target, start, mid - 1, Accum);
            return numOccurrences(Arr, target, mid + 1, end, Accum);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Empty Array");
            return -1;
        }
    }

}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prime10001
{
    internal class NaiveApproach
    {
        internal static long GetPrimeNumber(long index)
        {
            long primesFound = 0;
            long curNumber = 2;
            while (true)
            {
                if (IsPrime(curNumber))
                {
                    primesFound++;
                    if (primesFound == index)
                    {
                        return curNumber;
                    }
                }

                curNumber++;
            }
        }

        private static bool IsPrime(long number)
        {
            for (long i = 2; i < number; i++)
            {
                if (number % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}

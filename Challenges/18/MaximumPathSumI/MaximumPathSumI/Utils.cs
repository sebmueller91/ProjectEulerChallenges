using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    public static class Utils
    {
        internal static Triangle<int> ReadTriangleFromFile(string path = @"..\..\..\..\..\triangle.txt")
        {
            var lines = System.IO.File.ReadAllLines(path);
            var triangle = new Triangle<int>(lines.Length);

            for (int i = 0; i < lines.Length; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    var parsedLine = lines[i].Split(' ');
                    triangle[i][j] = Int32.Parse(parsedLine[j]);
                }
            }

            return triangle;
        }

        internal static int GetSummarizedPathValue(List<int> path, Triangle<int> triangle)
        {
            return GetSummarizedPathValue(path.ToArray(), triangle);
        }

        internal static int GetSummarizedPathValue(int[] path, Triangle<int> triangle)
        {
            int sum = 0;
            for (int i = 0; i < path.Length; i++)
            {
                sum += triangle[i][path[i]];
            }
            return sum;
        }

        internal static List<int> CopyListOfInts(List<int> a)
        {
            var c = new List<int>();
            c.AddRange(a);
            return c;
        }

        internal static void PrintSolution(List<int> path, Triangle<int> triangle)
        {
            Console.WriteLine("Index Value");
            for (int i = 0; i < path.Count; i++)
            {
                Console.Write(i + " ");
                Console.WriteLine(triangle[i][path[i]]);
            }
            Console.WriteLine("Sum: " + Utils.GetSummarizedPathValue(path, triangle));
        }
    }
}

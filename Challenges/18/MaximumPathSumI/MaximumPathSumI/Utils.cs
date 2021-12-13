using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    public static class Utils
    {
        internal static Triangle ReadTriangleFromFile(string path = @"..\..\..\..\..\triangle.txt")
        {
            var lines = System.IO.File.ReadAllLines(path);
            var triangle = new Triangle(lines.Length);

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
    }
}

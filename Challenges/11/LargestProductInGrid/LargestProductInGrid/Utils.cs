using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LargestProductInGrid
{
    internal static class Utils
    {
        internal static int[,] ReadGridFromFile(string path = @"..\..\..\..\..\grid.txt")
        {
            var lines = System.IO.File.ReadAllLines(path);
            int[,] grid = null;

            for (int i = 0; i < lines.Length; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    var parsedLine = lines[i].Split(' ');
                    if (grid == null)
                    {
                        grid = new int[lines.Length, parsedLine.Length];
                    }
                    grid[i,j] = Int32.Parse(parsedLine[j]);
                }
            }

            return grid;
        }
    }
}

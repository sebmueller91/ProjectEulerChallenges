using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    internal class BackwardsApproach
    {
        /// <summary>
        /// Calculates the path of adjacent values through the trianle with the maximum summed up values
        /// </summary>
        /// <returns>Indices of path entries</returns>
        internal static List<int> GetPathOfMaxValues(Triangle<int> triangle)
        {
            var bestValues = new Triangle<int>(triangle.GetNumerOfRows());
            var bestPaths = new Triangle<List<int>>(triangle.GetNumerOfRows());
            for (int i = 0; i < triangle.GetNumerOfRows(); i++)
            {
                for (int j = 0; j <= i; j++) { 
                    if (i < triangle.GetNumerOfRows() - 1)
                    {
                        bestValues[i][j] = int.MaxValue;
                        bestPaths[i][j] = null;
                    } else
                    {
                        bestValues[i][j] = triangle[i][j];
                        bestPaths[i][j] = new List<int> { j};
                    }
                }
            }
            
            for (int i = triangle.GetNumerOfRows() - 2; i >= 0; i--)
            {
                CalculateOptimalValuesForRow(i, triangle, bestValues, bestPaths);
            }

            return bestPaths[0][0];
        }

        private static void CalculateOptimalValuesForRow(int row, Triangle<int> triangle, Triangle<int> bestValues, Triangle<List<int>> bestPaths)
        {
            for (int i = 0; i <= row; i++)
            {
                CalculateOptimalValueForEntry(row, i, triangle, bestValues, bestPaths);
            }
        }

        private static void CalculateOptimalValueForEntry(int row, int col, Triangle<int> triangle, Triangle<int> bestValues, Triangle<List<int>> bestPaths)
        {
            // left path has higher value
            if (bestValues[row + 1][i] > bestValues[row + 1][col + 1])
            {
                bestValues[row][i] = bestValues[row + 1][col] + triangle[row][col];
                bestPaths[row][i] = new List<int> { col };
                bestPaths[row][i].AddRange(bestPaths[row + 1][col]);

            }
            else // right path higher
            {
                bestValues[row][i] = bestValues[row + 1][col + 1] + triangle[row][col];
                bestPaths[row][i] = new List<int> { col };
                bestPaths[row][i].AddRange(bestPaths[row + 1][col + 1]);
            }
        }
}

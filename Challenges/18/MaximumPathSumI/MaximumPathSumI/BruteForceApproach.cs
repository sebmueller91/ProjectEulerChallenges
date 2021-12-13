using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    internal class BruteForceApproach
    {
        /// <summary>
        /// Calculates the path of adjacent values through the trianle with the maximum summed up values
        /// </summary>
        /// <returns>Indices of path entries</returns>
        internal static List<int> GetPathOfMaxValues(Triangle triangle)
        {
            return GetMaxPath(triangle, new List<int> { 0 });
        }

        private static List<int> GetMaxPath(Triangle triangle, List<int> traversedPath)
        {
            if (traversedPath.Count == triangle.GetNumerOfRows())
            {
                return traversedPath;
            } else
            {
                var leftPath = Utils.CopyListOfInts(traversedPath);
                leftPath.Add(traversedPath.Last());
                var fullLeftPath = GetMaxPath(triangle, leftPath);
                var leftPathValue = Utils.GetSummarizedPathValue(fullLeftPath, triangle);

                var rightPath = traversedPath;
                rightPath.Add(traversedPath.Last() + 1);
                var fullRightPath = GetMaxPath(triangle, rightPath);
                var rightPathValue = Utils.GetSummarizedPathValue(fullRightPath, triangle);
                
                return (leftPathValue > rightPathValue) ? fullLeftPath : fullRightPath;
            }
        }
    }
}

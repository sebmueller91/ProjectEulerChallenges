// See https://aka.ms/new-console-template for more information
using MaximumPathSumI;

var triangle = Utils.ReadTriangleFromFile();
var path = BruteForceApproach.GetPathOfMaxValues(triangle);
var sum = Utils.GetSummarizedPathValue(path, triangle);

Console.WriteLine("Index Value");
for (int i = 0; i < path.Count; i++) {
    Console.Write(i + " ");
    Console.WriteLine(triangle[i][path[i]]);
}
Console.WriteLine("Sum: " + Utils.GetSummarizedPathValue(path, triangle));

Console.ReadKey();
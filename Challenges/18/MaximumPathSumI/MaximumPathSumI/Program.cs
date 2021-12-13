// See https://aka.ms/new-console-template for more information
using MaximumPathSumI;

var triangle = Utils.ReadTriangleFromFile();
var bruteForcePath = BruteForceApproach.GetPathOfMaxValues(triangle);
var backwardsPath = BackwardsApproach.GetPathOfMaxValues(triangle);

Console.WriteLine("Solution of Brute Force approach:");
Utils.PrintSolution(bruteForcePath, triangle);

Console.WriteLine("Solution of Backwards approach:");
Utils.PrintSolution(bruteForcePath, triangle);

Console.ReadKey();
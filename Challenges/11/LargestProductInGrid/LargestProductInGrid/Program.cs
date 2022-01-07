// See https://aka.ms/new-console-template for more information
using LargestProductInGrid;

var grid = Utils.ReadGridFromFile();
var product = GetLargestProduct.GetHighestProduct(grid);

Console.WriteLine($"Highest product: {product.Number1}*{product.Number2}*{product.Number3}*{product.Number4}={product.Multiply}");

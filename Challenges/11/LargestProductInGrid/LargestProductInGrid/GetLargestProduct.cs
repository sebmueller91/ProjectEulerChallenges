using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LargestProductInGrid
{
    internal class GetLargestProduct
    {
        internal static Product GetHighestProduct(int[,] grid)
        {
            var results = new List<Product>();
            results.Add(GetLargestVerticalProduct(grid));
            results.Add(GetLargestHorizontalProduct(grid));
            results.Add(GetLargestTopLeftDiagonalProduct(grid));
            results.Add(GetLargestBottomLeftDiagonalProduct(grid));

            return results.OrderByDescending(x => x.Multiply).FirstOrDefault();
        }

        private static Product GetLargestVerticalProduct(int[,] grid)
        {
            var bestResult = new Product(0, 0, 0, 0);
            for (int i = 0; i < grid.GetLength(0) - 3; i++)
            {
                for (int j = 0; j < grid.GetLength(1); j++)
                {
                    Product curProduct = new Product(grid[i, j], grid[i+1, j], grid[i+2, j], grid[i+3, j]);
                    if (curProduct.Multiply > bestResult.Multiply)
                    {
                        bestResult = curProduct;
                    }
                }
            }
            return bestResult;
        }

        private static Product GetLargestHorizontalProduct(int[,] grid)
        {
            var bestResult = new Product(0, 0, 0, 0);
            for (int i = 0; i < grid.GetLength(0); i++)
            {
                for (int j = 0; j < grid.GetLength(1)-3; j++)
                {
                    Product curProduct = new Product(grid[i, j], grid[i, j+1], grid[i, j+2], grid[i, j+3]);
                    if (curProduct.Multiply > bestResult.Multiply)
                    {
                        bestResult = curProduct;
                    }
                }
            }
            return bestResult;
        }

        private static Product GetLargestTopLeftDiagonalProduct(int[,] grid)
        {
            var bestResult = new Product(0, 0, 0, 0);
            for (int i = 0; i < grid.GetLength(0)-3; i++)
            {
                Product curProduct = new Product(grid[i, i], grid[i+1,i+1], grid[i + 2, i + 2], grid[i + 3, i + 3]);
            }
            return bestResult;
        }

        private static Product GetLargestBottomLeftDiagonalProduct(int[,] grid)
        {
            var bestResult = new Product(0, 0, 0, 0);
            for (int i = 0; i < grid.GetLength(0) - 3; i++)
            {
                int baseRow = grid.GetLength(0) - i - 1;
                Product curProduct = new Product(grid[baseRow, i], grid[baseRow - 1, i + 1], grid[baseRow - 2, i + 2], grid[baseRow - 3, i + 3]);
            }
            return bestResult;
        }

        internal class Product
        {
            public int Number1 { get; private set; }
            public int Number2 { get; private set; }
            public int Number3 { get; private set; }
            public int Number4 { get; private set; }
            public int Multiply { get; private set; }

            public Product(int number1, int number2, int number3, int number4)
            {
                Number1 = number1;
                Number2 = number2;
                Number3 = number3;
                Number4 = number4;
                Multiply = Number1 * Number2 * Number3 * Number4;
            }
        }
    }
}

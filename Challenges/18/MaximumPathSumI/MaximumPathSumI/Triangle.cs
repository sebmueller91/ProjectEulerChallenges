using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    internal class Triangle
    {
        private List<int[]> _entries;
        public Triangle(int rows)
        {
            _entries = new List<int[]>();
            for (int i = 0; i < rows; i++)
            {
                _entries.Add(new int[i+1]);
            }
        }

        public int[] this[int row]
        {
            get => GetRow(row);
            set => SetRow(row, value);
        }

        public void SetEntry(int row, int col, int value)
        {
            _entries[row][col] = value;
        }

        public void SetRow(int row, int[] values)
        {
            _entries[row] = values;
        }

        public int GetEntry(int row, int col)
        {
            return _entries[row][col];
        }

        public int[] GetRow(int row)
        {
            return _entries[row];
        }
    }
}

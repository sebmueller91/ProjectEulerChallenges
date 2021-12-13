using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaximumPathSumI
{
    internal class Triangle<T>
    {
        private List<T[]> _entries;
        public Triangle(int rows)
        {
            _entries = new List<T[]>();
            for (int i = 0; i < rows; i++)
            {
                _entries.Add(new T[i+1]);
            }
        }

        public int GetNumerOfRows()
        {
            return _entries.Count;
        }

        public T[] this[int row]
        {
            get => GetRow(row);
            set => SetRow(row, value);
        }

        public void SetEntry(int row, int col, T value)
        {
            _entries[row][col] = value;
        }

        public void SetRow(int row, T[] values)
        {
            _entries[row] = values;
        }

        public T GetEntry(int row, int col)
        {
            return _entries[row][col];
        }

        public T[] GetRow(int row)
        {
            return _entries[row];
        }
    }
}

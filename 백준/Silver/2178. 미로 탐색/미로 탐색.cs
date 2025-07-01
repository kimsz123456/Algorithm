using System;
using System.IO;
using System.Collections.Generic;

class Program
{
    static int n, m;
    static int[,] graph;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void Main()
    {
        StreamReader sr = new StreamReader(Console.OpenStandardInput());
        StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

        string[] input = sr.ReadLine().Split();
        n = int.Parse(input[0]);
        m = int.Parse(input[1]);

        graph = new int[n, m];

        for (int i = 0; i < n; i++)
        {
            string line = sr.ReadLine().Trim();
            for (int j = 0; j < m; j++)
            {
                graph[i, j] = line[j] - '0';
            }
        }

        sw.Write(BFS(0, 0));
        sw.Flush();
        sw.Close();
        sr.Close();
    }

    static int BFS(int x, int y)
    {
        Queue<(int, int)> queue = new Queue<(int, int)>();
        queue.Enqueue((x, y));

        while (queue.Count > 0)
        {
            (int cx, int cy) = queue.Dequeue();

            for (int i = 0; i < 4; i++)
            {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx, ny] == 1)
                {
                    queue.Enqueue((nx, ny));
                    graph[nx, ny] = graph[cx, cy] + 1;
                }
            }
        }

        return graph[n - 1, m - 1];
    }
}
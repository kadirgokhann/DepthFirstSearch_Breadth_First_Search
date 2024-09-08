package dfs_app;

public class HashTable {
    String[] table;
    int M;

    public HashTable(int M) {
        this.M = M;
        this.table = new String[M];
    }
    
    public int getIndexOf(String key) {
        return contains(key);
    }

    public int hashCode(String key) {
        return (key.hashCode() % M) & 0x7fffffff;
    }

    public int contains(String key) {
        int i = hashCode(key);
        int startIndex = i;
        while (true) {
            if (table[i] != null && table[i].equals(key)) {
                return i;
            }
            if (table[i] == null) {
                return -1;
            }
            i = (i + 1) % M;
            if (i == startIndex) {
                return -1;
            }
        }
    }

    public void print()
    {
        for (int i = 0; i < M; i++) {
            System.out.println(i  + ": " + table[i] + ", ");
        }
        System.out.println("");
    }

    public int insert(String key) {
        int i = hashCode(key);
        int index = contains(key);
        if (index != -1) {
            return index;
        }
        int startIndex = i;
        while (true) {
            if (table[i] == null) {
                table[i] = key;
                return i;
            }
            if (table[i] != null && table[i].equals(key)) {
                return i; 
            }      
            i = (i + 1) % M;
            if (i == startIndex) {
                System.out.println("Table is full!");
                for (int j = 0; j < M; j++) {
                    System.out.print(j + ": " + table[j] + ", ");
                }
                System.out.println("");
                return -1;
            }
        }
    }
}

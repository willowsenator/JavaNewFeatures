package org.willowsenator.textblocks;

public class TextBlocks {
    private static final String sql = """
                SELECT * FROM employees
                ORDER BY ASC
            """;

    public static void main(String[] args){
        System.out.println(sql);
    }
}

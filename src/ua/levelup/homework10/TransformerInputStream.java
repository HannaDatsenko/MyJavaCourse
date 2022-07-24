package ua.levelup.homework10;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class TransformerInputStream extends FilterInputStream{
     char from;
     char to;
    protected TransformerInputStream(InputStream in, char from, char to) {
        super(in);
        this.from = Character.valueOf(from);
        this.to = Character.valueOf(to);
    }
    @Override
    public int read() throws IOException {

        int ch = in.read();
            if (Character.valueOf((char)ch)==this.from){return this.to;};

            return ch;
    }

    public static void main(String[] args) {
        try(TransformerInputStream tis = new TransformerInputStream(new TransformerInputStream(System.in, 'a', 't'), 'e', 'w')) {
            int read;
            while ((read = tis.read()) != -1) {
                System.out.print((char)read);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

package org.sun.util;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Pattern;

/**
 * copy from edu.princeton.cs.algs4.In
 */
public class In {
    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE;
    private static final Pattern WHITESPACE_PATTERN;
    private static final Pattern EMPTY_PATTERN;
    private static final Pattern EVERYTHING_PATTERN;
    private Scanner scanner;

    public In() {
        this.scanner = new Scanner(new BufferedInputStream(System.in), "UTF-8");
        this.scanner.useLocale(LOCALE);
    }

    public In(Socket socket) {
        if (socket == null) {
            throw new NullPointerException("argument is null");
        } else {
            try {
                InputStream is = socket.getInputStream();
                this.scanner = new Scanner(new BufferedInputStream(is), "UTF-8");
                this.scanner.useLocale(LOCALE);
            } catch (IOException var3) {
                throw new IllegalArgumentException("Could not open " + socket);
            }
        }
    }

    public In(URL url) {
        if (url == null) {
            throw new NullPointerException("argument is null");
        } else {
            try {
                URLConnection site = url.openConnection();
                InputStream is = site.getInputStream();
                this.scanner = new Scanner(new BufferedInputStream(is), "UTF-8");
                this.scanner.useLocale(LOCALE);
            } catch (IOException var4) {
                throw new IllegalArgumentException("Could not open " + url);
            }
        }
    }

    public In(File file) {
        if (file == null) {
            throw new NullPointerException("argument is null");
        } else {
            try {
                FileInputStream fis = new FileInputStream(file);
                this.scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                this.scanner.useLocale(LOCALE);
            } catch (IOException var3) {
                throw new IllegalArgumentException("Could not open " + file);
            }
        }
    }

    public In(String name) {
        if (name == null) {
            throw new NullPointerException("argument is null");
        } else {
            try {
                File file = new File(name);
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    this.scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                    this.scanner.useLocale(LOCALE);
                } else {
                    URL url = this.getClass().getResource(name);
                    if (url == null) {
                        url = new URL(name);
                    }

                    URLConnection site = url.openConnection();
                    InputStream is = site.getInputStream();
                    this.scanner = new Scanner(new BufferedInputStream(is), "UTF-8");
                    this.scanner.useLocale(LOCALE);
                }
            } catch (IOException var6) {
                throw new IllegalArgumentException("Could not open " + name);
            }
        }
    }

    public In(Scanner scanner) {
        if (scanner == null) {
            throw new NullPointerException("argument is null");
        } else {
            this.scanner = scanner;
        }
    }

    public boolean exists() {
        return this.scanner != null;
    }

    public boolean isEmpty() {
        return !this.scanner.hasNext();
    }

    public boolean hasNextLine() {
        return this.scanner.hasNextLine();
    }

    public boolean hasNextChar() {
        this.scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = this.scanner.hasNext();
        this.scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    public String readLine() {
        String line;
        try {
            line = this.scanner.nextLine();
        } catch (NoSuchElementException var3) {
            line = null;
        }

        return line;
    }

    public char readChar() {
        this.scanner.useDelimiter(EMPTY_PATTERN);
        String ch = this.scanner.next();

        assert ch.length() == 1 : "Internal (Std)In.readChar() error! Please contact the authors.";

        this.scanner.useDelimiter(WHITESPACE_PATTERN);
        return ch.charAt(0);
    }

    public String readAll() {
        if (!this.scanner.hasNextLine()) {
            return "";
        } else {
            String result = this.scanner.useDelimiter(EVERYTHING_PATTERN).next();
            this.scanner.useDelimiter(WHITESPACE_PATTERN);
            return result;
        }
    }

    public String readString() {
        return this.scanner.next();
    }

    public int readInt() {
        return this.scanner.nextInt();
    }

    public double readDouble() {
        return this.scanner.nextDouble();
    }

    public float readFloat() {
        return this.scanner.nextFloat();
    }

    public long readLong() {
        return this.scanner.nextLong();
    }

    public short readShort() {
        return this.scanner.nextShort();
    }

    public byte readByte() {
        return this.scanner.nextByte();
    }

    public boolean readBoolean() {
        String s = this.readString();
        if (s.equalsIgnoreCase("true")) {
            return true;
        } else if (s.equalsIgnoreCase("false")) {
            return false;
        } else if (s.equals("1")) {
            return true;
        } else if (s.equals("0")) {
            return false;
        } else {
            throw new InputMismatchException();
        }
    }

    public String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(this.readAll());
        if (tokens.length != 0 && tokens[0].length() <= 0) {
            String[] decapitokens = new String[tokens.length - 1];

            for(int i = 0; i < tokens.length - 1; ++i) {
                decapitokens[i] = tokens[i + 1];
            }

            return decapitokens;
        } else {
            return tokens;
        }
    }

    public String[] readAllLines() {
        ArrayList<String> lines = new ArrayList();

        while(this.hasNextLine()) {
            lines.add(this.readLine());
        }

        return (String[])lines.toArray(new String[0]);
    }

    public int[] readAllInts() {
        String[] fields = this.readAllStrings();
        int[] vals = new int[fields.length];

        for(int i = 0; i < fields.length; ++i) {
            vals[i] = Integer.parseInt(fields[i]);
        }

        return vals;
    }

    public long[] readAllLongs() {
        String[] fields = this.readAllStrings();
        long[] vals = new long[fields.length];

        for(int i = 0; i < fields.length; ++i) {
            vals[i] = Long.parseLong(fields[i]);
        }

        return vals;
    }

    public double[] readAllDoubles() {
        String[] fields = this.readAllStrings();
        double[] vals = new double[fields.length];

        for(int i = 0; i < fields.length; ++i) {
            vals[i] = Double.parseDouble(fields[i]);
        }

        return vals;
    }

    public void close() {
        this.scanner.close();
    }

    /** @deprecated */
    @Deprecated
    public static int[] readInts(String filename) {
        return (new In(filename)).readAllInts();
    }

    /** @deprecated */
    @Deprecated
    public static double[] readDoubles(String filename) {
        return (new In(filename)).readAllDoubles();
    }

    /** @deprecated */
    @Deprecated
    public static String[] readStrings(String filename) {
        return (new In(filename)).readAllStrings();
    }

    /** @deprecated */
    @Deprecated
    public static int[] readInts() {
        return (new In()).readAllInts();
    }

    /** @deprecated */
    @Deprecated
    public static double[] readDoubles() {
        return (new In()).readAllDoubles();
    }

    /** @deprecated */
    @Deprecated
    public static String[] readStrings() {
        return (new In()).readAllStrings();
    }

    public static void main(String[] args) {
        String urlName = "http://introcs.cs.princeton.edu/stdlib/InTest.txt";
        System.out.println("readAll() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");

        In in;
        try {
            in = new In(urlName);
            System.out.println(in.readAll());
        } catch (Exception var4) {
            System.out.println(var4);
        }

        System.out.println();
        System.out.println("readLine() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");

        String s;
        try {
            in = new In(urlName);

            while(!in.isEmpty()) {
                s = in.readLine();
                System.out.println(s);
            }
        } catch (Exception var11) {
            System.out.println(var11);
        }

        System.out.println();
        System.out.println("readString() from URL " + urlName);
        System.out.println("---------------------------------------------------------------------------");

        try {
            in = new In(urlName);

            while(!in.isEmpty()) {
                s = in.readString();
                System.out.println(s);
            }
        } catch (Exception var10) {
            System.out.println(var10);
        }

        System.out.println();
        System.out.println("readLine() from current directory");
        System.out.println("---------------------------------------------------------------------------");

        try {
            in = new In("./InTest.txt");

            while(!in.isEmpty()) {
                s = in.readLine();
                System.out.println(s);
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }

        System.out.println();
        System.out.println("readLine() from relative path");
        System.out.println("---------------------------------------------------------------------------");

        try {
            in = new In("../stdlib/InTest.txt");

            while(!in.isEmpty()) {
                s = in.readLine();
                System.out.println(s);
            }
        } catch (Exception var8) {
            System.out.println(var8);
        }

        System.out.println();
        System.out.println("readChar() from file");
        System.out.println("---------------------------------------------------------------------------");

        try {
            in = new In("InTest.txt");

            while(!in.isEmpty()) {
                char c = in.readChar();
                System.out.print(c);
            }
        } catch (Exception var7) {
            System.out.println(var7);
        }

        System.out.println();
        System.out.println();
        System.out.println("readLine() from absolute OS X / Linux path");
        System.out.println("---------------------------------------------------------------------------");
        in = new In("/n/fs/introcs/www/java/stdlib/InTest.txt");

        try {
            while(!in.isEmpty()) {
                s = in.readLine();
                System.out.println(s);
            }
        } catch (Exception var6) {
            System.out.println(var6);
        }

        System.out.println();
        System.out.println("readLine() from absolute Windows path");
        System.out.println("---------------------------------------------------------------------------");

        try {
            in = new In("G:\\www\\introcs\\stdlib\\InTest.txt");

            while(!in.isEmpty()) {
                s = in.readLine();
                System.out.println(s);
            }

            System.out.println();
        } catch (Exception var5) {
            System.out.println(var5);
        }

        System.out.println();
    }

    static {
        LOCALE = Locale.US;
        WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
        EMPTY_PATTERN = Pattern.compile("");
        EVERYTHING_PATTERN = Pattern.compile("\\A");
    }
}

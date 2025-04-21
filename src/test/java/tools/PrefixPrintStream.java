package tools;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * A custom {@link PrintStream} that prefixes each line of output with a specified string.
 * This class is designed to wrap an existing {@link OutputStream} and prepend a prefix
 * (e.g., "out: ") to the beginning of each line, ensuring that the prefix is only added
 * once per line. It is particularly useful for distinguishing output sources, such as
 * standard output and error streams, in testing or logging scenarios.
 * <p>
 * The prefix is added when a non-whitespace, defined character is encountered at the
 * start of a line, and a new line is detected by the newline character ('\n').
 * The class maintains a state to track whether the current position is at the start
 * of a line, ensuring correct prefix application.
 *
 * @see PrintStream
 * @see OutputStream
 */
public class PrefixPrintStream extends PrintStream {
    private final String prefix;
    private boolean startOfLine = true;

    /**
     * Constructs a new {@code PrefixPrintStream} that wraps the specified
     * {@link OutputStream} and prepends the given prefix to each line of output.
     *
     * @param out    the underlying {@link OutputStream} to write to
     * @param prefix the string to prepend to each line of output (e.g., "out: ")
     */
    public PrefixPrintStream(OutputStream out, String prefix) {
        super(out);
        this.prefix = prefix;
    }

    /**
     * Writes a portion of a byte array to the underlying output stream, prepending
     * the configured prefix to each line of text. A line is considered to start when
     * the internal state indicates the beginning of a line (initially true or after a
     * newline character). The prefix is added only when a non-whitespace, defined
     * character is encountered at the start of a line.
     * <p>
     * The input bytes are converted to a string for processing, and each character is
     * examined to determine whether to add the prefix or mark the end of a line (via
     * '\n'). The resulting prefixed string is then written to the underlying stream.
     *
     * @param buf the byte array containing the data to write
     * @param off the starting offset in the byte array
     * @param len the number of bytes to write
     */
    @Override
    public void write(byte[] buf, int off, int len) {
        String s = new String(buf, off, len);
        StringBuilder prefixed = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (startOfLine && Character.isDefined(c) && !Character.isWhitespace(c)) {
                prefixed.append(prefix);
                startOfLine = false;
            }
            prefixed.append(c);
            if (c == '\n') {
                startOfLine = true;
            }
        }
        super.write(prefixed.toString().getBytes(), 0, prefixed.length());
    }
}
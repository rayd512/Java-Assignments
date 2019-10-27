import java.util.regex.*;

/**
 * Assignment 2: Java regular expressions <br />
 * Test cookies using regular expressions
 * @author Raynard Dizon 1531753
 */
public class CookieTest {

    /**
     * Verify a cookie and return the verification result
     * @param cookie        {@code String}  The cookie string
     * @return              {@code boolean} True for a legal cookie; false for an illegal one
     */
    public static boolean verifyCookie(String cookie) {
        // Boolean variable holding whether or not the cookie is legal
        boolean legal = false;

        // Compile the pattern for a valid cookie
        Pattern validCookiePat = Pattern.compile("^(Set-Cookie:\\s)([!-'*-\\.0-9A-Z^-z|~]+=([\"]*[!#-+\\--:<-\\[\\]-~]*" +
            "[\"]*(;\\s((Expires=(Mon|Tue|Wed|Thu|Fri|Sat|Sun),\\s[\\d]{2}\\s(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|" +
        	"Oct|Nov|Dec)\\s[\\d]{4}\\s[\\d]{2}:[\\d]{2}:[\\d]{2}\\sGMT)|(HttpOnly)|(Max-Age=[1-9]\\d*)|" +
        	"(Domain=([\\.]?([a-zA-Z]((([\\w]+-)+)?[\\w]+)?))*)|(Path=[!-:<-~]+)|(Secure)))*))");

        // Create a matcher to check if the pattern matches the string
		Matcher matchCookie = validCookiePat.matcher(cookie);

        // Set legal to if the cookie match the pattern of a valid cookie
        legal = matchCookie.matches();

		// Return a boolean whether or not the cookie is valid
        return legal;
    }

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String [] cookies = {
            // Legal cookies:
            "Set-Cookie: ns1=\"alss/0.foobar^\"",                                           // 01 name=value
            "Set-Cookie: ns1=",                                                             // 02 empty value
            "Set-Cookie: ns1=\"alss/0.foobar^\"; Expires=Tue, 18 Nov 2008 16:35:39 GMT",    // 03 Expires=time_stamp
            "Set-Cookie: ns1=; Domain=",                                                    // 04 empty domain
            "Set-Cookie: ns1=; Domain=.srv.a.com-0",                                        // 05 Domain=host_name
            "Set-Cookie: lu=Rg3v; Expires=Tue, 18 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly", // 06
            // Illegal cookies:
            "Set-Cookie:",                                              // 07 empty cookie-pair
            "Set-Cookie: sd",                                           // 08 illegal cookie-pair: no "="
            "Set-Cookie: =alss/0.foobar^",                              // 09 illegal cookie-pair: empty name
            "Set-Cookie: ns@1=alss/0.foobar^",                          // 10 illegal cookie-pair: illegal name
            "Set-Cookie: ns1=alss/0.foobar^;",                          // 11 trailing ";"
            "Set-Cookie: ns1=; Expires=Tue 18 Nov 2008 16:35:39 GMT",   // 12 illegal Expires value
            "Set-Cookie: ns1=alss/0.foobar^; Max-Age=01",               // 13 illegal Max-Age: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.0com",             // 14 illegal Domain: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.com-",             // 15 illegal Domain: trailing non-letter-digit
            "Set-Cookie: ns1=alss/0.foobar^; Path=",                    // 16 illegal Path: empty
            "Set-Cookie: ns1=alss/0.foobar^; httponly",                 // 17 lower case
        };
        for (int i = 0; i < cookies.length; i++)
            System.out.println(String.format("Cookie %2d: %s", i+1, verifyCookie(cookies[i]) ? "Legal" : "Illegal"));
    }

}

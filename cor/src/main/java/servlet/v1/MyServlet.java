package servlet.v1;

import java.util.LinkedList;
import java.util.List;

/**
 * v1: request是顺序调用，response也是顺序调用，假如想让request顺序调用，而response逆序调用，该如何处理？
 *
 * @author: Sean Yu
 * @create: 2020-10-16 08:41
 **/
public class MyServlet {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request : hi, <script>, hello from sean";
        Response response = new Response();
        response.str = "response : ";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<", "").replaceAll(">", "");
        response.str = response.str + "---servlet.v1.HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        String[] sensitiveWordsRegex = {"script"};
        for (String word : sensitiveWordsRegex) {
            if (request.str.contains(word)) {
                request.str = request.str.replaceAll(word, "");
            }
        }
        response.str = response.str + "---servlet.v1.SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new LinkedList();

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter f : filters) {
            f.doFilter(request, response);
        }
        response.str = response.str + "---servlet.v1.FilterChain()";
        return true;
    }
}

class Request {
    String str;
}

class Response {
    String str;
}




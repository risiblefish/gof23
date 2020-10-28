package servlet.v2;

import java.util.LinkedList;
import java.util.List;

/**
 * v1: request是顺序调用，response也是顺序调用，假如想让request顺序调用，而response逆序调用，该如何处理？
 *
 * v2: 通过让filter持有FilterChain的引用，在处理完request之后调用filterChain的doFilter方法
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
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "").replaceAll(">", "");
        //add
        filterChain.doFilter(request, response, filterChain);
        response.str = response.str + "---HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String[] sensitiveWordsRegex = {"script"};
        for (String word : sensitiveWordsRegex) {
            if (request.str.contains(word)) {
                request.str = request.str.replaceAll(word, "");
            }
        }
        //add
        filterChain.doFilter(request, response, filterChain);
        response.str = response.str + "---SensitiveFilter()";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new LinkedList();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return false;
        }
        filters.get(index++).doFilter(request, response, filterChain);
        return true;
    }
}

class Request {
    String str;
}

class Response {
    String str;
}




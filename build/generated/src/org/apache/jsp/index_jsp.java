package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css\" integrity=\"sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I\" crossorigin=\"anonymous\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Spartan:wght@300;600&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://kit.fontawesome.com/ffec4ec2ed.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\n");
      out.write("    <title>Login</title>\n");
      out.write("  </head>\n");
      out.write("  <body class=\"bg-dark\">\n");
      out.write("      <section>\n");
      out.write("        <div class=\"row g-0\">\n");
      out.write("            <div class=\"col-lg-7 d-none d-lg-block\">\n");
      out.write("                <div id=\"carouselExampleCaptions\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                      <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                      <li data-target=\"#carouselExampleCaptions\" data-slide-to=\"1\"></li>\n");
      out.write("                    </ol>\n");
      out.write("                    <div class=\"carousel-inner\">\n");
      out.write("                      <div class=\"carousel-item img-1 min-vh-100 active\">\n");
      out.write("                        <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                          \n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"carousel-item img-2 min-vh-100\">\n");
      out.write("                        <div class=\"carousel-caption d-none d-md-block\">\n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <a class=\"carousel-control-prev\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                      <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                      <span class=\"sr-only\">Previous</span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"carousel-control-next\" href=\"#carouselExampleCaptions\" role=\"button\" data-slide=\"next\">\n");
      out.write("                      <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                      <span class=\"sr-only\">Next</span>\n");
      out.write("                    </a>\n");
      out.write("                  </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-5 bg-dark d-flex flex-column align-items-end min-vh-100\">\n");
      out.write("                \n");
      out.write("                <div class=\"align-self-center w-100 px-lg-5 py-lg-4 p-10\">\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                <h1 class=\"font-weight-bold mb-4\">Bienvenido de vuelta</h1>\n");
      out.write("                <form class=\"mb-5\" action=\"IniciarSesion\" method=\"POST\">\n");
      out.write("                    <div class=\"mb-4\">\n");
      out.write("                      <label for=\"exampleInputEmail1\" class=\"form-label font-weight-bold\">Usuario</label>\n");
      out.write("                      <input type=\"text\" class=\"form-control bg-dark-x border-0\" id=\"usuario\" name=\"usuario\" placeholder=\"Ingresa tu usuario\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mb-4\">\n");
      out.write("                      <label for=\"exampleInputPassword1\" class=\"form-label font-weight-bold\">ContraseÃ±a</label>\n");
      out.write("                      <input type=\"password\" class=\"form-control bg-dark-x border-0 mb-2\" placeholder=\"Ingresa tu contraseÃ±a\" id=\"password\" name=\"password\">\n");
      out.write("                      \n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary w-100\">Iniciar sesiÃ³n</button>\n");
      out.write("                  </form>\n");
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      </section>\n");
      out.write("    <!-- Optional JavaScript -->\n");
      out.write("    <!-- Popper.js first, then Bootstrap JS -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js\" integrity=\"sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/\" crossorigin=\"anonymous\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!-- Ninguna de las imagenes son de mi propiedad, a continuaciÃ³n estÃ¡n los links de los autores\n");
      out.write("\n");
      out.write("ImÃ¡genes en Unsplash: https://unsplash.com/@xps\n");
      out.write("Logo Dell: https://worldvectorlogo.com/logo/dell-1\n");
      out.write("\n");
      out.write("-->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

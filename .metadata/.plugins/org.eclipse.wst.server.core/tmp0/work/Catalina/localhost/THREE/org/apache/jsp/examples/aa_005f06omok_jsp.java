/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.53
 * Generated at: 2019-01-03 03:42:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.examples;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aa_005f06omok_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("   \r\n");

	String pan = request.getParameter("pan");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>three.js webgl - geometry - cube</title>\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0\">\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\tbody {\r\n");
      out.write("\t\t\t\tmargin: 0px;\r\n");
      out.write("\t\t\t\tbackground-color: #000000;\r\n");
      out.write("\t\t\t\toverflow: hidden;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body id=\"my_body\" onload=\"fn_load()\">\r\n");
      out.write("\t\t<script src=\"jquery-1.12.4.js\"></script>\r\n");
      out.write("\t\t<script src=\"../build/three.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/controls/OrbitControls.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar camera, scene, renderer;\r\n");
      out.write("\t\t\tvar mesh;\r\n");
      out.write("\t\t\tvar mesh1;\r\n");
      out.write("\t\t\tvar mesh2;\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar gStoneBlack;\r\n");
      out.write("\t\t\tvar texture1;\r\n");
      out.write("\t\t\tvar material1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar gStoneWhite;\r\n");
      out.write("\t\t\tvar texture2;\r\n");
      out.write("\t\t\tvar material2;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction fn_load(){\r\n");
      out.write("\t\t\t\tinit();\r\n");
      out.write("\t\t\t\tanimate();\r\n");
      out.write("\t\t\t\tfn_ajax2();\r\n");
      out.write("\t// \t\t\tfn_addStone();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tcamera = new THREE.PerspectiveCamera( 70, window.innerWidth / window.innerHeight, 1, 1000 );\r\n");
      out.write("\t\t\t\tcamera.position.z = 700;\r\n");
      out.write("\t\t\t\tcamera.rotation.z = Math.PI;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tscene = new THREE.Scene();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tvar gPan = new THREE.PlaneBufferGeometry( 600, 600, 8, 8 );\r\n");
      out.write("\t\t\t\tvar texture = new THREE.TextureLoader().load( 'textures/omok/omokpan.png' );\r\n");
      out.write("\t\t\t\tvar material = new THREE.MeshBasicMaterial( { map: texture } );\r\n");
      out.write("\t\t\t\tvar mesh = new THREE.Mesh( gPan, material );\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tscene.add( mesh );\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tgStoneBlack = new THREE.CylinderBufferGeometry( 20, 20, 5, 40, 20 );\r\n");
      out.write("\t\t\t\ttexture1 = new THREE.TextureLoader().load( 'textures/omok/o_b.jpg' );\r\n");
      out.write("\t\t\t\tmaterial1 = new THREE.MeshBasicMaterial( { map: texture1 } );\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tgStoneWhite = new THREE.CylinderBufferGeometry( 20, 20, 5, 40, 20 );\r\n");
      out.write("\t\t\t\ttexture2 = new THREE.TextureLoader().load( 'textures/omok/o_w.jpg' );\r\n");
      out.write("\t\t\t\tmaterial2 = new THREE.MeshBasicMaterial( { map: texture2 } );\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tmesh1 = new THREE.Mesh( gStoneBlack, material1 );\r\n");
      out.write("\t\t\t\tmesh1.rotation.x = Math.PI * 0.5; \r\n");
      out.write("\t\t\t\tmesh1.position.x = -270;\r\n");
      out.write("\t\t\t\tmesh1.position.y = 270;\r\n");
      out.write("\t\t\t\tmesh1.position.z = 2.5;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tscene.add( mesh1 );\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tmesh2 = new THREE.Mesh( gStoneWhite, material2 );\r\n");
      out.write("\t\t\t\tmesh2.rotation.x = Math.PI * 0.5; \r\n");
      out.write("\t\t\t\tmesh2.position.x = 270;\r\n");
      out.write("\t\t\t\tmesh2.position.y = -270;\r\n");
      out.write("\t\t\t\tmesh2.position.z = 2.5;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tscene.add( mesh2 );\r\n");
      out.write("\r\n");
      out.write("\t\t\t\trenderer = new THREE.WebGLRenderer( { antialias: true } );\r\n");
      out.write("\t\t\t\trenderer.setPixelRatio( window.devicePixelRatio );\r\n");
      out.write("\t\t\t\trenderer.setSize( window.innerWidth, window.innerHeight );\r\n");
      out.write("\t\t\t\tdocument.body.appendChild( renderer.domElement );\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t//\r\n");
      out.write("\r\n");
      out.write("\t\t\t\twindow.addEventListener( 'resize', onWindowResize, false );\r\n");
      out.write("\t\t\t\tvar orbit = new THREE.OrbitControls( camera, renderer.domElement ); // 시점 변경\r\n");
      out.write("\t            orbit.update();\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction onWindowResize() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tcamera.aspect = window.innerWidth / window.innerHeight;\r\n");
      out.write("\t\t\t\tcamera.updateProjectionMatrix();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\trenderer.setSize( window.innerWidth, window.innerHeight );\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar index_scene = 0;\r\n");
      out.write("\t\t\tvar index_omok = 0;\r\n");
      out.write("\t\t\tfunction animate() {\r\n");
      out.write("// \t\t\t\tconsole.log(\"index_scene\"+index_scene);\r\n");
      out.write("\t\t\t\tindex_scene++;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\trequestAnimationFrame( animate );\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif((index_scene % 60) == 0){\r\n");
      out.write("\t\t\t\t\tfn_draw_onestone();\r\n");
      out.write("\t\t\t\t\tindex_omok++;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t/* \tmesh1.rotation.x -= 0.01;\r\n");
      out.write("\t\t\t\tmesh2.rotation.x -= 0.01; */\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//mesh2.position.x = 50;\r\n");
      out.write("\r\n");
      out.write("//\t\t\t\tmesh.rotation.x += 0.005;\r\n");
      out.write("//\t\t\t\tmesh.rotation.y += 0.01;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\trenderer.render( scene, camera );\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction fn_draw_onestone() {\r\n");
      out.write("\t            var str = arrHist[index_omok];\r\n");
      out.write("\t            \r\n");
      out.write("\t            var ii = -1;\r\n");
      out.write("\t            var jj = -1;\r\n");
      out.write("\t            var int_status = -1;\r\n");
      out.write("\t            var int_temp   = -1;\r\n");
      out.write("\t            \r\n");
      out.write("\t            if (index_omok == 0) {\r\n");
      out.write("\t               for (var i = 0; i < str.length; i++) {\r\n");
      out.write("\t                  var str_temp = str.substring(i, i + 1);\r\n");
      out.write("\t                  \r\n");
      out.write("\t                  if (str_temp > 0) {\r\n");
      out.write("\t                     int_status    = Number(str_temp);\r\n");
      out.write("\t                     int_temp    = i;\r\n");
      out.write("\t                     break;\r\n");
      out.write("\t                  }\r\n");
      out.write("\t               }\r\n");
      out.write("\t            } else if (index_omok < arrHist.length) {\r\n");
      out.write("\t               var str_pre = arrHist[index_omok - 1];\r\n");
      out.write("\t               for (var i = 0; i < str.length; i++) {\r\n");
      out.write("\t                  var str_temp     = str.substring(i, i + 1);\r\n");
      out.write("\t                  var str_temp_pre = str_pre.substring(i, i + 1);\r\n");
      out.write("\t                  \r\n");
      out.write("\t                  if (str_temp != str_temp_pre) {\r\n");
      out.write("\t                     int_status    = Number(str_temp);\r\n");
      out.write("\t                     int_temp    = i;\r\n");
      out.write("\t                     break;\r\n");
      out.write("\t                  }\r\n");
      out.write("\t               }\r\n");
      out.write("\t            } else {\r\n");
      out.write("\t               return;\r\n");
      out.write("\t            }\r\n");
      out.write("\t            \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tii = parseInt(int_temp / 10);\r\n");
      out.write("\t\t\t\tjj = int_temp % 10;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfn_addStone(ii, jj, int_status);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar pan = ");
      out.print(pan);
      out.write(";\r\n");
      out.write("\t\t\tvar arrHist = new Array();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction fn_ajax2(){\r\n");
      out.write("\t\t\t\talert(\"pan:\"+pan);\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\t\turl : \"http://127.0.0.1/GAMESOCKET/myselpan_jsonp\",\r\n");
      out.write("\t\t\t\t\tdata : { pan: pan},\r\n");
      out.write("\t\t\t\t\tdataType : \"jsonp\",\r\n");
      out.write("\t\t\t\t\tjsonpCallback: \"myCallback\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tfor(var i = 0; i < data.length; i++){\r\n");
      out.write("\t\t\t\t\t\t\tarrHist.push(data[i].history);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tconsole.log(arrHist);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\terror : function(xhr, status, error) {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"에러!: \" + error);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction fn_addStone(ii, jj, int_status){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar startX = -270;\r\n");
      out.write("\t\t\t\tvar startY = 270;\r\n");
      out.write("\t\t\t\tvar endX = 270;\r\n");
      out.write("\t\t\t\tvar endY = -270;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar betweenX = (endX - startX) / (10 - 1);\r\n");
      out.write("\t\t\t\tvar betweenY = (endY - startY) / (10 - 1);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar meshTemp;\r\n");
      out.write("\t\t\t\tif(int_status == 1){\r\n");
      out.write("\t\t\t\t\tmeshTemp = new THREE.Mesh( gStoneBlack, material1 ); \r\n");
      out.write("\t\t\t\t} else if(int_status == 2){\r\n");
      out.write("\t\t\t\t\tmeshTemp = new THREE.Mesh( gStoneWhite, material2 );\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tmeshTemp.rotation.x = Math.PI * 0.5; \r\n");
      out.write("\t\t\t\tmeshTemp.position.x = startX + (jj*betweenX);\r\n");
      out.write("\t\t\t\tmeshTemp.position.y = startY + (ii*betweenY);\r\n");
      out.write("\t\t\t\tmeshTemp.position.z = 2.5;\r\n");
      out.write("\t\t\t\tscene.add(meshTemp);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t/* \t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfor(var i = 0; i < 10; i ++){\r\n");
      out.write("\t\t\t\t\tfor(var j = 0; j < 10; j++){\r\n");
      out.write("\t\t\t\t\t\tvar meshTemp = new THREE.Mesh( gStoneBlack, material1 );\r\n");
      out.write("\t\t\t\t\t\tmeshTemp.rotation.x = Math.PI * 0.5; \r\n");
      out.write("\t\t\t\t\t\tmeshTemp.position.x = startX + (j*betweenX);\r\n");
      out.write("\t\t\t\t\t\tmeshTemp.position.y = startY + (i*betweenY);\r\n");
      out.write("\t\t\t\t\t\tmeshTemp.position.z = 2.5;\r\n");
      out.write("\t\t\t\t\t\tscene.add(meshTemp);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t */\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

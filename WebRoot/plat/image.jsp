<%@ page import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>    
<%@ page import="java.io.OutputStream"%>    
<%@ page pageEncoding="UTF-8"%>
<%@page import="cn.com.xb.util.SessionManger"%>    
<%!Color getRandColor(int fc, int bc) {    
                Random random = new Random();    
                if (fc > 255)    
                        fc = 255;    
                if (bc > 255)    
                        bc = 255;    
                int r = fc + random.nextInt(bc - fc);    
                int g = fc + random.nextInt(bc - fc);    
                int b = fc + random.nextInt(bc - fc);    
                return new Color(r, g, b);    
        }%>
<%!
	String getSrand() {
		String sRand = "";
		String chose = "0123456789";
		for (int i = 0; i < 4; i++) {
			int idx = (int) Math.floor(Math.random() * (chose.length()));
			char rand = chose.charAt(idx);
			sRand += rand;
		}
		//System.out.println(sRand);
		return sRand;
	}
 %>
        <%    	//String sRand = request.getParameter("sRand");
        		String sRand = getSrand();
				System.setProperty("java.awt.headless","true");		//add DingLiang 20120903
				//String sRand = "1111";
                try {    
                response.setHeader("Pragma", "No-cache");    
                response.setHeader("Cache-Control", "no-cache");    
                response.setDateHeader("Expires", 0);    
                int width = 55, height = 20;    
                BufferedImage image = new BufferedImage(width, height,    
                BufferedImage.TYPE_INT_RGB);    
                //OutputStream os = response.getOutputStream();    
                Graphics g = image.getGraphics();    
                Random random = new Random();  
                //设置背景和大小 
                //g.setColor(getRandColor(200, 250));    
                 g.setColor(new Color(Integer.parseInt("ebebeb",16))); 
                g.fillRect(0, 0, width, height);    
                //设置字体和颜色
                g.setFont(new Font("Times New Roman", Font.PLAIN, 20));    
                g.setColor(getRandColor(120, 200));   
                
                for (int i = 0; i < 155; i++) {    
                        int x = random.nextInt(width);    
                        int y = random.nextInt(height);    
                        int xl = random.nextInt(5);    
                        int yl = random.nextInt(5);    
                        //g.drawLine(x, y, x + xl, y + yl);    
                }    
                  
                for (int i = 0; i < 4; i++) {
                    //String chose="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    //String rand = String.valueOf(chose.charAt(random.nextInt(chose.length())));    
                    //sRand += rand;  
                    String rand = sRand.charAt(i) + "";  
                    //g.setColor(new Color(20 + random.nextInt(110), 20 + random    
                    //.nextInt(110), 20 + random.nextInt(110)));  
                    g.setColor(Color.BLACK);    
                    //g.drawString(rand, 15 * i + 6, 16);    
                    g.drawString(rand, 15 * i , 16);    
                }    
                //session.setAttribute("rand", sRand);    
                g.dispose();    
				
		response.reset();	//add DingLiang 20120903
				
                ImageIO.write(image, "JPEG", response.getOutputStream());    
		//out.flush();	//add DingLiang 20120903
                //os.flush();    
                //os.close();    
                //os = null;    
                //response.flushBuffer();
                //request.getSession().setAttribute("CODE", sRand);
                SessionManger.updateYZMSession(request,sRand);
                
                out.clear();    
                out = pageContext.pushBody();    
        } catch (IllegalStateException e) {    
                System.out.println(e.getMessage());    
                e.printStackTrace();    
        }    
%>
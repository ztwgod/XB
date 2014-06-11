package cn.com.xb.util.box;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FreemarkerUtil {
	private static Configuration cfg;

	static {
		String path = FreemarkerUtil.class.getResource("").getPath();
		cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File(path));
			cfg.setTemplateUpdateDelay(10);
			cfg.setDefaultEncoding("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getContext(Map<String, Object> root, String FTLname) throws TemplateException, IOException {
		StringWriter sw = new StringWriter();
		Template t = cfg.getTemplate(FTLname);
		t.process(root, sw);
		root.clear();
		String str = sw.toString();
		sw.close();
		return str;
	}
}

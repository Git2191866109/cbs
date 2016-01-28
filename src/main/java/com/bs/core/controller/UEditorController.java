package com.bs.core.controller;

import com.baidu.ueditor.ActionEnter;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.Uploader;

import com.bs.core.initialize.InitializeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * User: zhangqh6
 * Date: 2015/12/14 18:17:17
 */
@Controller
@RequestMapping("/ue")
public class UEditorController {
    @Autowired
    private InitializeData initializeData;

    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/config.json")
    public void excute(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        PrintWriter writer = response.getWriter();
        String action = request.getParameter("action");
        String rootPath = initializeData.getPicUploadUrl().get("ueditorRoot");

        if("config".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).exec() );
        }else if("uploadimage".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("uploadscrawl".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("catchimage".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("uploadvideo".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("uploadfile".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("listimage".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }else if("listfile".equals(action)) {
            writer.write(new ActionEnter(request, rootPath).invoke() );
        }
    }

    @RequestMapping(value = "/uploadimage.json")
    public String uploadimage(HttpServletRequest request,
                     HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }

    @RequestMapping(value = "/uploadscrawl.json")
    public String uploadscrawl(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }
    @RequestMapping(value = "/catchimage.json")
    public String catchimage(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }
    @RequestMapping(value = "/uploadvideo.json")
    public String uploadvideo(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }
    @RequestMapping(value = "/uploadfile.json")
    public String uploadfile(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }
    @RequestMapping(value = "/listimage.json")
    public String listimage(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }

    @RequestMapping(value = "/listfile.json")
    public String listfile(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        Map<String, Object> conf = new HashMap<>();
        State state = new Uploader(request, conf).doExec();
        return state.toJSONString();
    }

}

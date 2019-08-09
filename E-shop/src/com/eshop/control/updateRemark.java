package com.eshop.control;

import com.eshop.service.RemarkImpl.RemarkImpl;
import com.eshop.service.RemarkService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateRemark",urlPatterns = {"/updateRemark"})
public class updateRemark extends HttpServlet {
    Logger log = Logger.getLogger(updateRemark.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int remarkId = Integer.parseInt(request.getParameter("remarkId"));
        String remark = request.getParameter("remark");
        String remarkLevel = request.getParameter("remarkLevel");

        RemarkService res = new RemarkImpl();
        res.updateRemark(remarkId,remark,remarkLevel);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int remarkId = Integer.parseInt(request.getParameter("remarkId"));
         new RemarkImpl().deleteRemark(remarkId);
    }
}

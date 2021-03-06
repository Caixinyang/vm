package com.vm.admin.controller;

import com.vm.auth.admin.aop.IgnoreExtendAdminSessionLife;
import com.vm.auth.admin.aop.RequiredAdminLogin;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.resolver.OnlineAdmin;
import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.auth.admin.aop.RequiredAuth;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/admin")
@Scope("prototype")
public class VmAdminsController extends ServiceController<VmAdminsService> {
    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object adminLogin(VmAdminsDto vmAdminsDto) throws Exception {

        VmAdminsDto admin = service.adminLogin(vmAdminsDto);

        return response.putData("admin", admin).setMsg("登录成功");
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    @ResponseBody
    public Object adminLogout(@OnlineAdmin VmAdminsDto onlineAdmin) throws Exception {

        if (!isNullObject(onlineAdmin) && !isNullObject(onlineAdmin.getId())) {

            service.adminLogout(onlineAdmin.getToken());
        }

        return response.setMsg("登出成功");
    }

    /**
     * 获取在线用户
     *
     * @return
     */
    @IgnoreExtendAdminSessionLife
    @RequestMapping(value = "/online", method = RequestMethod.GET)
    @ResponseBody
    public Object getOnlineAdmin(@OnlineAdmin VmAdminsDto onlineAdmin) throws Exception {

        return response.putData("admin", onlineAdmin);
    }

    /**
     * 获取列表
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"admin:select"})
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getAdmins(PageBean page, VmAdminsQueryBean query) throws Exception {

        return response.putData("list", service.getAdmins(page, query)).putData("total", service.getAdminsTotal(page, query));
    }

    /**
     * 更新
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"admin:edit"})
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editAdmin(VmAdminsDto vmAdminsDto) throws Exception {

        return response.putData("admin", service.editAdmin(vmAdminsDto));
    }

    /**
     * 添加
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"admin:add"})
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addAdmin(VmAdminsDto vmAdminsDto) throws Exception {

        return response.putData("admin", service.addAdmin(vmAdminsDto));
    }

    /**
     * 删除
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"admin:delete"})
    @RequestMapping(value = "/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteAdmin(@RequestBody VmAdminsDto vmAdminsDto) throws Exception {
        service.deleteAdmin(vmAdminsDto);
        return response;
    }
}

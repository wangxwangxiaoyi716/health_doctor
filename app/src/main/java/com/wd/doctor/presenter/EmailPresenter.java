package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.EmailContract;
import com.wd.doctor.model.EmailModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/15
 *@Time:18:50
 *@Description:
 **/
public class EmailPresenter extends BasePresenter<EmailContract.Iview> implements EmailContract.Ipresenter {

    private EmailModel emailModel;

    @Override
    protected void initModel() {
        emailModel = new EmailModel();
    }

    @Override
    public void onEmailPresenter(String email) {
        emailModel.onEmailModel(email, new EmailContract.Imodel.IMtroWork() {
            @Override
            public void onEmailSuccess(SendEmailCodeBean sendEmailCodeBean) {
                getView().onEmailSuccess(sendEmailCodeBean);
            }

            @Override
            public void onEmailFliuse(String resultes) {
                getView().onEmailFliuse(resultes);
            }
        });
    }
}

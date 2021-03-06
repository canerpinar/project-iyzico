package com.service.installment;


import com.service.entity.HttpClients;
import com.service.entity.IyziResources;
import com.service.entity.SecretOptions;

import java.util.List;

public class InstallmentInf extends IyziResources {
    private List<InstallmentDetails> installmentDetails;

    public InstallmentInf() {
    }

    public static InstallmentInf retrieve(RetrieveInstallmentRequest request, SecretOptions options) {
        return (InstallmentInf) HttpClients.create().post(options.getBaseUrl() + "/payment/iyzipos/installment", getHttpHeaders(request, options), request, InstallmentInf.class);
    }

    public List<InstallmentDetails> getInstallmentDetails() {
        return this.installmentDetails;
    }

    public void setInstallmentDetails(List<InstallmentDetails> installmentDetails) {
        this.installmentDetails = installmentDetails;
    }
/*
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(InstallmentDetails inf : getInstallmentDetails()){
            for(InstallmentPrice price : inf.getInstallmentPrices()){

            }
        }
    }

 */
}

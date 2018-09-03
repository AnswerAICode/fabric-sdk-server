package com.hyperledger.fabric.sdk.entity.dto.api;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by answer on 2018-09-03 14:31
 *
 * 构建客户端需要传入操作员区块的用户信息
 */
public class BuildClientDTO {

    private String name;
    private String mspId;
    private String mspPath;

    private BuildClientDTO(Builder builder) {
        this.mspPath = builder.mspPath;
        this.name = builder.name;
        this.mspId = builder.mspId;
    }

    public String getName() {
        return name;
    }

    public String getMspId() {
        return mspId;
    }

    public String getMspPath() {
        return mspPath;
    }


    /**
     * path: crypto-config/peerOrganizations/org1.example.com/users/Admin@org1.example.com/msp/
     * cert: path + signcerts
     * key: path + keystore
     * */
    public static class Builder {
        private String name;
        private String mspId;
        private String mspPath;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder mspId(String mspId) {
            this.mspId = mspId;
            return this;
        }

        public Builder mspPath(String mspPath) {
            this.mspPath = mspPath;
            return this;
        }

        public BuildClientDTO build() {
            if (StringUtils.isEmpty(mspPath) || StringUtils.isEmpty(name)|| StringUtils.isEmpty(mspId)) {
                throw new IllegalArgumentException("name | mspId | mspPath must not be empty.");
            }
            return new BuildClientDTO(this);
        }
    }

}

package com.ayobuataplikasi.datamahasiswa.responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("mhs")
    @Expose
    private List<Mhs> mhs = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Mhs> getMhs() {
        return mhs;
    }

    public void setMhs(List<Mhs> mhs) {
        this.mhs = mhs;
    }

}

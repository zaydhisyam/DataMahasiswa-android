
package com.ayobuataplikasi.datamahasiswa.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Mhs implements Serializable {

    @SerializedName("nim")
    @Expose
    private String nim;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("fakultas")
    @Expose
    private String fakultas;
    @SerializedName("jurusan")
    @Expose
    private String jurusan;
    @SerializedName("prodi")
    @Expose
    private String prodi;
    @SerializedName("seleksi")
    @Expose
    private String seleksi;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getSeleksi() {
        return seleksi;
    }

    public void setSeleksi(String seleksi) {
        this.seleksi = seleksi;
    }

}

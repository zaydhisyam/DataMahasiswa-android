<?php

class Database {

    //fungsi constructor, set database
    public function __construct() {
        $this->db = new PDO('mysql:host=localhost; dbname=data_mahasiswa', 'root', 'passwordbaru');
    }

    //fungsi ambil data mahasiswa
    public function getAllData() {
        $query = "SELECT * FROM mahasiswa";
        $sql = $this->db->query($query);
        return $sql;
    } 

    public function getData($nim) {
        $query = "SELECT * FROM mahasiswa WHERE nim='$nim' LIMIT 1";
        $sql = $this->db->query($query);
        return $sql;
    }

    public function setData($nim, $nama, $fakultas, $jurusan, $prodi, $seleksi) {
        $query = "INSERT INTO mahasiswa VALUES('$nim', '$nama', '$fakultas', '$jurusan', '$prodi', '$seleksi')";
        $sql = $this->db->query($query);
        return $sql;
    }

    public function updateData($nim, $nama, $fakultas, $jurusan, $prodi, $seleksi) {
        $query = "UPDATE mahasiswa SET nama='$nama', fakultas='$fakultas', jurusan='$jurusan', prodi='$prodi', seleksi='$seleksi' WHERE nim='$nim'";
        $sql = $this->db->query($query);
        return $sql;
    }

    public function deleteData($nim) {
        $query = "DELETE FROM mahasiswa WHERE nim='$nim'";
        $sql = $this->db->query($query);
        return $sql;
    }

    // public function getFakultas($fakultas) {
    //     $query = "SELECT * FROM mahasiswa WHERE fakultas='$fakultas'";
    //     $sql = $this->db->query($query);
    //     return $sql;
    // }

    // public function getJurusan($jurusan) {
    //     $query = "SELECT * FROM mahasiswa WHERE jurusan='$jurusan'";
    //     $sql = $this->db->query($query);
    //     return $sql;
    // }

    // public function getProdi($prodi) {
    //     $query = "SELECT * FROM mahasiswa WHERE prodi='$prodi'";
    //     $sql = $this->db->query($query);
    //     return $sql;
    // }
}
<?php

include 'models.php';

//ambil data dari android
$key = $_REQUEST['key'];

if ($key == 'create') {
    // ambil data dari device
    $nim = $_REQUEST['nim'];
    $nama = $_REQUEST['nama'];
    $fakultas = $_REQUEST['fakultas'];
    $jurusan = $_REQUEST['jurusan'];
    $prodi = $_REQUEST['prodi'];
    $seleksi = $_REQUEST['seleksi'];
    
    //buat objek database
    $buatKoneksi = new Database();
    $buatKoneksi->setData($nim, $nama, $fakultas, $jurusan, $prodi, $seleksi);
    
    //set data ke json
    echo json_encode(array('status'=>true));
}
else {
    echo json_encode(array('status'=>false));
}
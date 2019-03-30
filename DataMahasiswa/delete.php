<?php

include 'models.php';

//ambil data dari android
$key = $_REQUEST['key'];

if ($key == 'delete') {
    //ambil data dari device
    $nim = $_REQUEST['nim'];
    
    //buat objek database
    $buatKoneksi = new Database();
    $buatKoneksi->deleteData($nim);
    
    //set data ke json
    echo json_encode(array('status'=>true));
}
else {
    echo json_encode(array('status'=>false));
}

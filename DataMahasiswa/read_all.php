<?php

include 'models.php';

//ambil data dari device
$key = $_REQUEST['key'];

if ($key == 'read_all') {
    //buat objek database
    $buatKoneksi = new Database();
    $getObjek = $buatKoneksi->getAllData();

    //buat array
    $jsonResponse = array();

    while ($baris = $getObjek->fetch(PDO::FETCH_OBJ)) {
        $jsonResponse[] = $baris;
    }

    //set data ke json
    echo json_encode(array('status'=>true, 'mhs'=>$jsonResponse));
}
else {
    echo json_encode(array('status'=>false));
}
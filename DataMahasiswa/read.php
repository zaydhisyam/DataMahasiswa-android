<?php

include 'models.php';

//ambil data dari android
$key = $_REQUEST['key'];

if ($key == 'read') {
    //buat objek database
    $buatKoneksi = new Database();
    $nim = $_REQUEST['nim'];
    $getObjek = $buatKoneksi->getData($nim);
    
    //buat array
    $jsonResponse = array();
    
    while ($row = $getObjek->fetch(PDO::FETCH_OBJ)) {
        $jsonResponse[] = $row;
    }
    
    //set data ke json
    echo json_encode(array('status'=>true, 'mhs'=>$jsonResponse));
}
else {
    echo json_encode(array('status'=>false));
}
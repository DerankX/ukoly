<html>
<body>

<form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">
IPv4: 
    <input type="number" name="ok1" min="0" max="255">
    <input type="number" name="ok2" min="0" max="255">
    <input type="number" name="ok3" min="0" max="255">
    <input type="number" name="ok4" min="0" max="255">
Prefix:
    <input type="number" name="prefix" min="0" max="32">

    <input type="submit">
</form>
 <?php 
 if ($_SERVER ["REQUEST_METHOD"] == "POST"){
     $ok1 = $_POST["ok1"];
     $ok2 = $_POST["ok2"];
     $ok3 = $_POST["ok3"];
     $ok4 = $_POST["ok4"];
     $prefix = $_POST["prefix"];
     $po = (int)($prefix / 8);
     $ph = 32 - $prefix;
     $ph = (2 ** $ph) - 2;
     $vm = $prefix % 8; 
     $vm2 = 8 - $vm;
     $m = 255 - (2**$vm2 - 1);
     if ($po == 4){
         $mok1 = 255;
         $mok2 = 255;
         $mok3 = 255;
         $mok4 = 255;
     }
     elseif($po == 3){
        $mok1 = 255;
        $mok2 = 255;
        $mok3 = 255;
        $mok4 = $m;
     }
     elseif($po == 2){
        $mok1 = 255;
        $mok2 = 255;
        $mok3 = $m;
        $mok4 = 0;
     }
     elseif($po == 1){
        $mok1 = 255;
        $mok2 = $m;
        $mok3 = 0;
        $mok4 = 0;
     }
     elseif($po == 0){
        $mok1 = $m;
        $mok2 = 0;
        $mok3 = 0;
        $mok4 = 0;
     }
     $binok1 = decbin($ok1);
     $binok2 = decbin($ok2);
     $binok3 = decbin($ok3);
     $binok4 = decbin($ok4);
    echo "Mask: $mok1:$mok2:$mok3:$mok4 ";
    $binmok1 = decbin($mok1);
    $binmok2 = decbin($mok2);
    $binmok3 = decbin($mok3);
    $binmok4 = decbin($mok4);
    echo "BinMask: ";
    echo str_pad($binmok1,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binmok2,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binmok3,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binmok4,8,"0",STR_PAD_LEFT);
    echo "<br>";
    echo "Network: $ok1:$ok2:$ok3:$ok4 ";
    echo "BinNetwork: ";
    echo str_pad($binok1,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binok2,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binok3,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binok4,8,"0",STR_PAD_LEFT);
    echo "<br>";
    $fh = $ok4 + 1;
    echo "FirstHost: $ok1:$ok2:$ok3:$fh ";
    echo "BinFirstHost: ";
    echo str_pad($binok1,8,"0", STR_PAD_LEFT);
    echo ":";
    echo str_pad($binok2,8,"0", STR_PAD_LEFT);
    echo ":";
    echo str_pad($binok3,8,"0", STR_PAD_LEFT);
    echo ":";
    $binfh = decbin($fh);
    echo str_pad($binfh,8,"0", STR_PAD_LEFT);
    $lh1 = $ok1;
    $lh2 = $ok2;
    $lh3 = $ok3;
    $lh4 = $ok4;
    if($po == 3){
       $lh4 = $ph;
    }
    elseif($po == 2){
        $lh3 = (int)($ph / 256);
        $lh4 = $ph % 256;
    }
    elseif($po == 1){
        $lh2 = $lh2 + (int)($ph / 65536);
        $lh3 = 255;
        $lh4 = 254;
    }
    elseif($po == 0){
        $lh1 = $lh1 + (int)($ph / 16777216);
        $lh2 = 255;
        $lh3 = 255;
        $lh4 = 254;
    }
    echo "<br>";
    echo "LastHost: $lh1:$lh2:$lh3:$lh4 ";
    echo "BinLastHost: ";
    $binlh1 = decbin($lh1);
    $binlh2 = decbin($lh2);
    $binlh3 = decbin($lh3);
    $binlh4 = decbin($lh4);
    echo str_pad($binlh1,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binlh2,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binlh3,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binlh4,8,"0",STR_PAD_LEFT);
    echo "<br>";
    $br = $lh4 + 1;
    echo "Broadcast: $lh1:$lh2:$lh3:$br ";
    $binbr = decbin($br);
    echo "BinBroadcast: ";
    echo str_pad($binlh1,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binlh2,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binlh3,8,"0",STR_PAD_LEFT);
    echo ":";
    echo str_pad($binbr,8,"0",STR_PAD_LEFT);
    echo "<br>";
    echo "<br>";
    echo "Počet Hostů: $ph";

 }
 
 
 ?>

</body>
</html>
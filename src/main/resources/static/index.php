<?php
define("APPLICATION_PATH",  dirname(__FILE__));

$app  = new Yaf_Application(APPLICATION_PATH . "/conf/application.ini");
$app->bootstrap() //Выполнение методов, опрделенных в Bootstrap.php
 ->run();
?>
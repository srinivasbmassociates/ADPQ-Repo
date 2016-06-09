<?php 
 class  Authenticatetest extends PHPUnit_Framework_TestCase {

 	public function testfindOne(){
 		$path= new ..\app\authenticate();
 		$this->assertTrue(is_array($path->findone('parent@gmail.com','1234','1')));
 	}
 }
?>
<?php 
 class  Createusertest extends PHPUnit_Framework_TestCase {

  public function insert(){
    $path= new ..\app\createuser();
	$post = array(
	        'Name'     => 'jon',
	        'Lname'   => 'thomes',
	        'Address'  => 'test',
			'Zipcode'=>'90008',
			'Dateofbirth'=>'1987-03-18',
			'Gender'     =>'1',
	        'Phone'   => '1234567890',
	        'Email'  => 'test@gmail.com',
			'Password'=>'1234',
			'Typeofuser'=>'1',
			'Upddate'=>'2016-06-04'
	    );
    $this->assertTrue($path->insert($post));
  }
 }
?>
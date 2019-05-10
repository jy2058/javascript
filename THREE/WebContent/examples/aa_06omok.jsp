<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	String pan = request.getParameter("pan");
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>three.js webgl - geometry - cube</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
		<style>
			body {
				margin: 0px;
				background-color: #000000;
				overflow: hidden;
			}
		</style>
	</head>
	<body id="my_body" onload="fn_load()">
		<script src="jquery-1.12.4.js"></script>
		<script src="../build/three.js"></script>
		<script src="js/controls/OrbitControls.js"></script>

		<script>

			var camera, scene, renderer;
			var mesh;
			var mesh1;
			var mesh2;

			var gStoneBlack;
			var texture1;
			var material1;
			
			var gStoneWhite;
			var texture2;
			var material2;
			
			function fn_load(){
				init();
				animate();
				fn_ajax2();
	// 			fn_addStone();
			}
			

			function init() {

				camera = new THREE.PerspectiveCamera( 70, window.innerWidth / window.innerHeight, 1, 1000 );
				camera.position.z = 700;
				camera.rotation.z = Math.PI;

				scene = new THREE.Scene();


				var gPan = new THREE.PlaneBufferGeometry( 600, 600, 8, 8 );
				var texture = new THREE.TextureLoader().load( 'textures/omok/omokpan.png' );
				var material = new THREE.MeshBasicMaterial( { map: texture } );
				var mesh = new THREE.Mesh( gPan, material );
				
				scene.add( mesh );
				
				gStoneBlack = new THREE.CylinderBufferGeometry( 20, 20, 5, 40, 20 );
				texture1 = new THREE.TextureLoader().load( 'textures/omok/o_b.jpg' );
				material1 = new THREE.MeshBasicMaterial( { map: texture1 } );

				gStoneWhite = new THREE.CylinderBufferGeometry( 20, 20, 5, 40, 20 );
				texture2 = new THREE.TextureLoader().load( 'textures/omok/o_w.jpg' );
				material2 = new THREE.MeshBasicMaterial( { map: texture2 } );
				
				mesh1 = new THREE.Mesh( gStoneBlack, material1 );
				mesh1.rotation.x = Math.PI * 0.5; 
				mesh1.position.x = -270;
				mesh1.position.y = 270;
				mesh1.position.z = 2.5;

				scene.add( mesh1 );
				
				mesh2 = new THREE.Mesh( gStoneWhite, material2 );
				mesh2.rotation.x = Math.PI * 0.5; 
				mesh2.position.x = 270;
				mesh2.position.y = -270;
				mesh2.position.z = 2.5;
				
				scene.add( mesh2 );

				renderer = new THREE.WebGLRenderer( { antialias: true } );
				renderer.setPixelRatio( window.devicePixelRatio );
				renderer.setSize( window.innerWidth, window.innerHeight );
				document.body.appendChild( renderer.domElement );

				//

				window.addEventListener( 'resize', onWindowResize, false );
				var orbit = new THREE.OrbitControls( camera, renderer.domElement ); // 시점 변경
	            orbit.update();

			}

			function onWindowResize() {

				camera.aspect = window.innerWidth / window.innerHeight;
				camera.updateProjectionMatrix();

				renderer.setSize( window.innerWidth, window.innerHeight );

			}

			var index_scene = 0;
			var index_omok = 0;
			function animate() {
// 				console.log("index_scene"+index_scene);
				index_scene++;

				requestAnimationFrame( animate );
				
				if((index_scene % 60) == 0){
					fn_draw_onestone();
					index_omok++;
				}
			/* 	mesh1.rotation.x -= 0.01;
				mesh2.rotation.x -= 0.01; */
				
				//mesh2.position.x = 50;

//				mesh.rotation.x += 0.005;
//				mesh.rotation.y += 0.01;

				renderer.render( scene, camera );
			}
			
			function fn_draw_onestone() {
	            var str = arrHist[index_omok];
	            
	            var ii = -1;
	            var jj = -1;
	            var int_status = -1;
	            var int_temp   = -1;
	            
	            if (index_omok == 0) {
	               for (var i = 0; i < str.length; i++) {
	                  var str_temp = str.substring(i, i + 1);
	                  
	                  if (str_temp > 0) {
	                     int_status    = Number(str_temp);
	                     int_temp    = i;
	                     break;
	                  }
	               }
	            } else if (index_omok < arrHist.length) {
	               var str_pre = arrHist[index_omok - 1];
	               for (var i = 0; i < str.length; i++) {
	                  var str_temp     = str.substring(i, i + 1);
	                  var str_temp_pre = str_pre.substring(i, i + 1);
	                  
	                  if (str_temp != str_temp_pre) {
	                     int_status    = Number(str_temp);
	                     int_temp    = i;
	                     break;
	                  }
	               }
	            } else {
	               return;
	            }
	            
				
				ii = parseInt(int_temp / 10);
				jj = int_temp % 10;
				
				fn_addStone(ii, jj, int_status);
			}
			
			var pan = <%=pan%>;
			var arrHist = new Array();
			
			function fn_ajax2(){
				alert("pan:"+pan);
				$.ajax({
					type : "get",
					url : "http://127.0.0.1/GAMESOCKET/myselpan_jsonp",
					data : { pan: pan},
					dataType : "jsonp",
					jsonpCallback: "myCallback",

					success : function(data) {
						
						for(var i = 0; i < data.length; i++){
							arrHist.push(data[i].history);
						}
						
						console.log(arrHist);
					},
				
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},
				});
			}
			

			function fn_addStone(ii, jj, int_status){
			
			var startX = -270;
				var startY = 270;
				var endX = 270;
				var endY = -270;
				
				var betweenX = (endX - startX) / (10 - 1);
				var betweenY = (endY - startY) / (10 - 1);
				
				var meshTemp;
				if(int_status == 1){
					meshTemp = new THREE.Mesh( gStoneBlack, material1 ); 
				} else if(int_status == 2){
					meshTemp = new THREE.Mesh( gStoneWhite, material2 );
				}
				meshTemp.rotation.x = Math.PI * 0.5; 
				meshTemp.position.x = startX + (jj*betweenX);
				meshTemp.position.y = startY + (ii*betweenY);
				meshTemp.position.z = 2.5;
				scene.add(meshTemp);
				
				
				/* 	
				
				for(var i = 0; i < 10; i ++){
					for(var j = 0; j < 10; j++){
						var meshTemp = new THREE.Mesh( gStoneBlack, material1 );
						meshTemp.rotation.x = Math.PI * 0.5; 
						meshTemp.position.x = startX + (j*betweenX);
						meshTemp.position.y = startY + (i*betweenY);
						meshTemp.position.z = 2.5;
						scene.add(meshTemp);

					}
				}
				 */
			}

		</script>
	</body>
</html>
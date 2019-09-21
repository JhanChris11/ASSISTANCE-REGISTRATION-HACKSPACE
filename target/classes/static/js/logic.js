$(".formAsistence").on('click','.btnRegister',function(e){

	e.preventDefault();

	swal({

      type:"warning",
      title:"¿Estas Seguro que desea Registrarte?",
      text:"Si no es asi entonces de click en Cerrar",
      showCancelButton: true,
      confirmButtonColor: '#35b0ab',
      cancelButtonColor: '#f77754',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Si,Registrar!'

    }).then(function(result){

      if(result.value){

        window.location="/registrar";

      }

    })

})

$(".formEdit").on('click','.btnEdit',function(e){

	e.preventDefault();

	swal({

      type:"warning",
      title:"¿Estas Seguro que deseas Actualizar?",
      text:"Si no es asi entonces de click en Cerrar",
      showCancelButton: true,
      confirmButtonColor: '#35b0ab',
      cancelButtonColor: '#f77754',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Si,Editar!'

    }).then(function(result){

      if(result.value){

        $(".formEdit").submit();

      }

    })

})
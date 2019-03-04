#######################
# Instalador AplicacionTwitter #
#######################

	#Incluir UI moderna
	!include "MUI2.nsh"

	#Alertamos al usuario cuando pulsa el botón cancelar y pedir confirmación
	!define mui_abortwarning

	#Definimos el valor de la variable VERSION
	!define VERSION "1.0"

	#Paginas instalador
	!insertmacro MUI_PAGE_WELCOME 
	!insertmacro MUI_PAGE_DIRECTORY 
	!insertmacro MUI_PAGE_INSTFILES 
	!insertmacro MUI_PAGE_FINISH

	#Paginas desinstalador
	!insertmacro MUI_UNPAGE_WELCOME
	!insertmacro MUI_UNPAGE_CONFIRM
	!insertmacro MUI_UNPAGE_INSTFILES
	!insertmacro MUI_UNPAGE_FINISH

	#Idiomas
	!insertmacro MUI_LANGUAGE "Spanish"


#########################
# Configuración General #
#########################

	#Nombre del instalador
	OutFile install.exe

	Name "Cliente de Twitter"
	Caption "Cliente de Twitter ${VERSION} Setup"

	#Comprobacion de integridad del fichero activada
	CRCCheck on

	#Pedimos permisos para acceder a $PROGRAMFILES
	RequestExecutionLevel admin

	#Directorio por defecto
	InstallDir $DESKTOP

	DirText "Elija un directorio donde instalar la aplicación:"
	#Indicamos que cuando la instalación se complete no se cierre el instalador automáticamente
	AutoCloseWindow false
	#Mostramos todos los detalles del la instalación al usuario.
	ShowInstDetails show
	#En caso de encontrarse los ficheros se sobreescriben
	SetOverwrite on
	#Optimizamos nuestro paquete en tiempo de compilación
	SetDatablockOptimize on
	#Habilitamos la compresión de nuestro instalador
	SetCompress auto
	#Personalizamos el mensaje de desinstalación
	UninstallText "Se va a desinstalar el software del equipo."


################################
# Configuración de instalación #
################################

	# Seccion del intalador
	Section

		# Establecemos el directorio de salida al directorio de instalacion
		SetOutPath $INSTDIR\AplicacionTwitter
		  
		# Grabar los archivos necesarios
		File DAMTweet.jar
		File /r lib
		File /r archivos_informes
		File /r help
		File /r bbdd

		# Creamos el desinstalador
		WriteUninstaller "$INSTDIR\AplicacionTwitter\uninstall.exe"
		  
		# Crear accesos directos
		CreateDirectory "$SMPROGRAMS\AplicacionTwitter"
		CreateShortCut "$SMPROGRAMS\AplicacionTwitter\DesinstalarAplicacionTwitter.lnk" "$INSTDIR\AplicacionTwitter\uninstall.exe" 
		CreateShortCut "$SMPROGRAMS\AplicacionTwitter\AplicacionTwitter.lnk" "$INSTDIR\AplicacionTwitter\DAMTweet.jar" 
		CreateShortCut "$DESKTOP\AplicacionTwitter.lnk" "$INSTDIR\AplicacionTwitter\DAMTweet.jar" 
		  
		#Añadimos información para que salga en el menú de desinstalar de Windows
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AplicacionTwitter" \
					   "DisplayName" "AplicacionTwitter"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AplicacionTwitter" \
					   "Publisher" "Silvia, Ana y Kevin - Desarrollo Interfaces"
		WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AplicacionTwitter" \
					   "UninstallString" "$\"$INSTDIR\AplicacionTwitter\uninstall.exe$\""
	  
	# Fin de la seccion
	SectionEnd




###################################
# Configuración de desinstalación #
###################################

# Seccion del desintalador
Section "uninstall"
 
    # Borrar el desintalador primero
    Delete "$INSTDIR\uninstall.exe"
    Delete "$INSTDIR\install.exe"

    # Borrar los archivos 
    Delete "$INSTDIR\DAMTweet.jar"
    RMDir /r "$INSTDIR\archivos_informes"
    RMDir /r "$INSTDIR\lib"
	RMDir /r "$INSTDIR\help"
	RMDir /r "$INSTDIR\bbdd"

    # Borrar el directorio 
    RMDir "$INSTDIR\..\AplicacionTwitter"

    # Borrar los accesos directos
	Delete "$DESKTOP\AplicacionTwitter.lnk"
    Delete "$SMPROGRAMS\AplicacionTwitter\DesinstalarAplicacionTwitter.lnk"
    Delete "$SMPROGRAMS\AplicacionTwitter\AplicacionTwitter.lnk"
	RMDir "$SMPROGRAMS\AplicacionTwitter"
 
    #Borramos la entrada del registro
	DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\AplicacionTwitter"
 
# Fin de la seccion del desinstalador
SectionEnd

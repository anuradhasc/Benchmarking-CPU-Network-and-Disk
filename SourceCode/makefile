JFLAGS = -g
JC = javac
RM = rm -f

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	callingDisk.java\
	Client.java\
	Server.java\
	UDPClient.java\
	UDPServer.java\
	CPUFloat.java\
	ThreadDemoCPUInteger.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

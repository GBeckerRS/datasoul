#!/bin/bash -x

SOURCEDIR=../datasoul-src
DISTDIR=$SOURCEDIR/dist
DSVERSION=$(awk -F= '/version/{ print $2 }' $SOURCEDIR/src/datasoul/version.properties)

if [[ "$USER" != "root" ]]
then
	echo "Please run this script as root"
	exit 0
fi

##################################################

# Clean up and build
rm -Rf installers
cd $SOURCEDIR
ant clean jar
rm -f dist/README.TXT
cd -
mkdir installers

##################################################

# Build debian
mkdir -p debian/datasoul/usr/share/datasoul
cp -r $DISTDIR/* debian/datasoul/usr/share/datasoul
cd debian
sed -i "s/Version:.*/Version: ${DSVERSION}/" datasoul/DEBIAN/control
chown -R root.root datasoul
chmod g-w -R datasoul
dpkg -b datasoul
mv datasoul.deb ../installers/datasoul_${DSVERSION}_all.deb
rm -Rf datasoul/usr/share/datasoul/*
cd ..

# Build RPM
cd installers
alien -k --scripts --to-rpm datasoul_${DSVERSION}_all.deb
cd ..

# Build MacOSX
MACINSTDIR=installers/Datasoul-${DSVERSION}-MacOSX/Datasoul-${DSVERSION}.app
mkdir -p ${MACINSTDIR}
cp -r MacOSX/Contents ${MACINSTDIR}
cp -r $DISTDIR/* ${MACINSTDIR}/Contents/Resources/Java
cp -r ../native/macos/* ${MACINSTDIR}/Contents/Resources
cd installers
zip -r Datasoul-${DSVERSION}-MacOSX.zip Datasoul-${DSVERSION}-MacOSX
cd ..
rm -Rf installers/Datasoul-${DSVERSION}-MacOSX

# Build Windows
makensis windows.nsi
mv Datasoul-${DSVERSION}.exe installers/Datasoul-${DSVERSION}-Windows.exe

###################################################
# Clean up
cd $SOURCEDIR
ant clean
cd -

# Create source tarball
mkdir datasoul-$DSVERSION
cp  -r $SOURCEDIR/*  datasoul-$DSVERSION
rm -rf datasoul-$DSVERSION/lib
rm -rf datasoul-$DSVERSION/nbproject/private
tar czvf installers/datasoul-$DSVERSION-source.tar.gz datasoul-$DSVERSION
rm -Rf datasoul-$DSVERSION



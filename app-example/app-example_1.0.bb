LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# COMMON_LICENSE_DIR=./yocto/poky/meta/files/common-licenses, check via "bitbake -e your_recipe_name | grep COMMON_LICENSE_DIR=". Get hash via "md5sum MIT"

# URL to git repository and branch
SRC_URI = "git://github.com/DanGdl/App-Example.git;protocol=https;branch=main"

# sha hash of desired commit
SRCREV = "a80f21c51a2f8ee89bccc984f3097f64f37bf869"

SRC_URI:append = " file://0001-patch.patch"

S = "${WORKDIR}/git"

do_configure() {
    echo "#define FLAG_PATCH" > app-example.h
}

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/app-example.c -o app-example 
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/app-example ${D}${bindir}
}



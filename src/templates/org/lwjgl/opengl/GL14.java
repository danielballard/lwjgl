/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opengl;

import org.lwjgl.util.generator.*;

import java.nio.*;

/**
 * <p/>
 * The core OpenGL1.4 API.
 *
 * @author cix_foo <cix_foo@users.sourceforge.net>
 * @version $Revision$
 * $Id$
 */
public interface GL14 {
	int GL_GENERATE_MIPMAP = 0x8191;
	int GL_GENERATE_MIPMAP_HINT = 0x8192;
	int GL_DEPTH_COMPONENT16 = 0x81A5;
	int GL_DEPTH_COMPONENT24 = 0x81A6;
	int GL_DEPTH_COMPONENT32 = 0x81A7;
	int GL_TEXTURE_DEPTH_SIZE = 0x884A;
	int GL_DEPTH_TEXTURE_MODE = 0x884B;
	int GL_TEXTURE_COMPARE_MODE = 0x884C;
	int GL_TEXTURE_COMPARE_FUNC = 0x884D;
	int GL_COMPARE_R_TO_TEXTURE = 0x884E;
	int GL_FOG_COORDINATE_SOURCE = 0x8450;
	int GL_FOG_COORDINATE = 0x8451;
	int GL_FRAGMENT_DEPTH = 0x8452;
	int GL_CURRENT_FOG_COORDINATE = 0x8453;
	int GL_FOG_COORDINATE_ARRAY_TYPE = 0x8454;
	int GL_FOG_COORDINATE_ARRAY_STRIDE = 0x8455;
	int GL_FOG_COORDINATE_ARRAY_POINTER = 0x8456;
	int GL_FOG_COORDINATE_ARRAY = 0x8457;
	int GL_POINT_SIZE_MIN = 0x8126;
	int GL_POINT_SIZE_MAX = 0x8127;
	int GL_POINT_FADE_THRESHOLD_SIZE = 0x8128;
	int GL_POINT_DISTANCE_ATTENUATION = 0x8129;
	int GL_COLOR_SUM = 0x8458;
	int GL_CURRENT_SECONDARY_COLOR = 0x8459;
	int GL_SECONDARY_COLOR_ARRAY_SIZE = 0x845A;
	int GL_SECONDARY_COLOR_ARRAY_TYPE = 0x845B;
	int GL_SECONDARY_COLOR_ARRAY_STRIDE = 0x845C;
	int GL_SECONDARY_COLOR_ARRAY_POINTER = 0x845D;
	int GL_SECONDARY_COLOR_ARRAY = 0x845E;
	int GL_BLEND_DST_RGB = 0x80C8;
	int GL_BLEND_SRC_RGB = 0x80C9;
	int GL_BLEND_DST_ALPHA = 0x80CA;
	int GL_BLEND_SRC_ALPHA = 0x80CB;
	int GL_INCR_WRAP = 0x8507;
	int GL_DECR_WRAP = 0x8508;
	int GL_TEXTURE_FILTER_CONTROL = 0x8500;
	int GL_TEXTURE_LOD_BIAS = 0x8501;
	int GL_MAX_TEXTURE_LOD_BIAS = 0x84FD;
	int GL_MIRRORED_REPEAT = 0x8370;

	void glBlendEquation(@GLenum int mode);

	void glBlendColor(@GLclampf float red, @GLclampf float green, @GLclampf float blue, @GLclampf float alpha);

	void glFogCoordf(float coord);

	void glFogCoordd(double coord);

	void glFogCoordPointer(@AutoType("data") @GLenum int type, @GLsizei int stride,
	                       @CachedReference
	                       @BufferObject(BufferKind.ArrayVBO)
	                       @Check
	                       @Const
	                       @GLfloat
	                       @GLdouble Buffer data);

	@Code("		if (piFirst.remaining() != piCount.remaining()) {\n" +
	      "			throw new IllegalArgumentException(\"piFirst.remaining() != piCount.remaining()\");\n" +
	      "		}")
	void glMultiDrawArrays(@GLenum int mode, IntBuffer piFirst, @Check @GLsizei IntBuffer piCount, @AutoSize("piFirst") @GLsizei int primcount);

	//void glMultiDrawElements(int mode, int piCount, int type, int pIndices, int primcount);

	void glPointParameteri(@GLenum int pname, int param);

	void glPointParameterf(@GLenum int pname, float param);

	@StripPostfix("params")
	void glPointParameteriv(@GLenum int pname, @Check("4") @Const IntBuffer params);

	@StripPostfix("params")
	void glPointParameterfv(@GLenum int pname, @Check("4") @Const FloatBuffer params);

	void glSecondaryColor3b(byte red, byte green, byte blue);

	void glSecondaryColor3f(float red, float green, float blue);

	void glSecondaryColor3d(double red, double green, double blue);

	void glSecondaryColor3ub(@GLubyte byte red, @GLubyte byte green, @GLubyte byte blue);

	void glSecondaryColorPointer(int size, @AutoType("data") @GLenum int type, @GLsizei int stride,
	                             @BufferObject(BufferKind.ArrayVBO)
	                             @Check
	                             @Const
	                             @GLbyte
	                             @GLubyte
	                             @GLfloat
	                             @GLdouble Buffer data);

	void glBlendFuncSeparate(@GLenum int sfactorRGB, @GLenum int dfactorRGB, @GLenum int sfactorAlpha, @GLenum int dfactorAlpha);

	void glWindowPos2f(float x, float y);

	void glWindowPos2d(double x, double y);

	void glWindowPos2i(int x, int y);

	void glWindowPos3f(float x, float y, float z);

	void glWindowPos3d(double x, double y, double z);

	void glWindowPos3i(int x, int y, int z);
}

